package com.asadulloh.quronozbek;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Toast;

import org.jsoup.Jsoup;


public class AppUpdateChecker {
    private Activity activity;

    public AppUpdateChecker(Activity activity) {
        this.activity = activity;
    }

    //current version of app installed in the device
    private String getCurrentVersion() {
        PackageManager pm = activity.getPackageManager();
        PackageInfo pInfo = null;
        try {
            pInfo = pm.getPackageInfo(activity.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e1) {
            e1.printStackTrace();
        }
        return pInfo.versionName;
    }

    private class GetLatestVersion extends AsyncTask<String, String, String> {
        private String latestVersion;
        private ProgressDialog progressDialog;
        private boolean manualCheck;

        GetLatestVersion(boolean manualCheck) {
            this.manualCheck = manualCheck;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (manualCheck) {
                if (progressDialog != null) {
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                }
            }
            String currentVersion = getCurrentVersion();
            //If the versions are not the same
            if (!currentVersion.equals(latestVersion) && latestVersion != null) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Ilovaning yangi ko'rinishi tayyor");
                builder.setMessage("Yangilash uchun 'Yangilash' ni bosing");
                builder.setPositiveButton("Yangilash", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Click button action
                        activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + activity.getPackageName())));
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Cancel button action
                    }
                });
                builder.setCancelable(false);
                builder.show();
            } else {
                if (manualCheck) {
                    Toast.makeText(activity, "Ilovaning yangi ko'rinishi yo'q", Toast.LENGTH_SHORT).show();
                }
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (manualCheck) {
                progressDialog = new ProgressDialog(activity);
                progressDialog.setMessage("Yangi ko'rinishni tekshirmoqda.....");
                progressDialog.setCancelable(false);
                progressDialog.show();
            }
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                //It retrieves the latest version by scraping the content of current version from play store at runtime
                latestVersion = Jsoup.connect("https://play.google.com/store/apps/details?id=" + activity.getPackageName() + "&hl=it")
                        .timeout(30000)
                        .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                        .referrer("http://www.google.com")
                        .get()
                        .select(".hAyfc .htlgb")
                        .get(7)
                        .ownText();
                return latestVersion;
            } catch (Exception e) {
                return latestVersion;
            }
        }
    }

    public void checkForUpdate(boolean manualCheck) {
        new GetLatestVersion(manualCheck).execute();
    }
}

