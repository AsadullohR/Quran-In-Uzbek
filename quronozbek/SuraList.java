package com.asadulloh.quronozbek;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

import java.lang.reflect.Field;
import java.util.ArrayList;


public class SuraList extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "SuraList";

    private Sura sura = new Sura();
    ListView listView;

    ArrayList<String> arrayList;

    String[] mTitle = {"Tanishtiruv","Fotiha", "Baqara", "Oli Imron", "Niso", "Moida", "An'om", "A'rof", "Anfol", "Tavba", "Yunus", "Hud", "Yusuf", "Ro'd", "Ibrohim", "Hijr", "Nahl", "Isro", "Kahf", "Maryam", "Toha", "Anbiyo", "Haj", "Mu'minun", "Nur", "Furqon", "Shuaro", "Naml", "Qosos", "Ankabut", "Rum", "Luqmon", "Sajda", "Ahzob", "Saba'", "Fotir", "Yaasiyn", "Soffat", "Sod", "Zumar", "G'ofir", "Fussilat", "Shuuro", "Zuxruf", "Duxon", "Josiya", "Ahqof", "Muhammad", "Fath", "Hujurot", "Qof", "Zoriyot", "Tur", "Najm", "Qamar", "Ar-Rohman", "Voqi'a", "Hadid", "Mujodala", "Hashr", "Mumtahana", "Sooff", "Juma", "Munofiqun", "Tag'obun", "Taloq", "Tahrim", "Mulk", "Qalam", "Haaqqo", "Ma'orij", "Nuh", "JIn", "Muzzammil", "Muddassir", "Qiyaama", "Inson", "Mursalat", "Naba'", "Nazi'aat", "Abasa", "Takvir", "Infitor", "Mutoffifun", "Inshiqoq", "Buruj", "Toriq", "A'laa", "G'oshiya", "Fajr", "Balad", "SHams", "Layl", "Zuho", "Sharh", "Tiyn", "Alaq", "Qadr", "Bayyina", "Zalzala", "A'diyat", "Qori'a", "Takaasur", "Asr", "Humaza", "Fiyl", "Quraysh", "Maa'uun", "Kavsar", "Kaafirun", "Nasr", "Masad", "Ixlos", "Falaq", "Naas", "    "};
    String[] mDescription = {"Ushbu ilovadan asosiy maqsad ","Ochuvchi", "Sigir", "Imron oilasi", "Ayol", "Yasatilgan dasturxon", "Chorva mollari", "Balandlik", "Ziyoda", "Tavba", "Yunus", "Hud", "Yusuf", "Momaqaldiroq", "Ibrohim", "Hijr", "Asalari", "Kechasi Yurgizish", "G'or", "Maryam", "Toha", "Payg'ambarlar", "Haj", "Mo'minlar", "Nur", "Farqlovchi", "Shoirlar", "Chumoli", "Qissa", "O'rgimchak", "Rim", "Luqmon", "Sajda", "Firqalar", "Yaman", "Yo'qdan bor qiluvchi", "Yaasiyn", "Saf tortib turuvchilar", "Sod", "Guruhlar", "Kechiruvchi", "Mufassal bayon qilingan", "Maslahat", "Ziynat", "Tutun", "Tiz Cho'kuvchi", "Qum tepaliklar", "Muhammad", "Fath", "Hujralar", "Qof", "Zaariyat", "Tur", "Najm", "Oy", "Ar-Rohman", "Voqi'a", "Temir", "Tortishuv", "Ko'chirish", "Imtihon qilingan ayol", "Saf", "Jamlanish", "Munofiqlar", "Tag'obun", "Taloq", "Tahrim", "Mulk", "Qalam", "Haqiqatda bo'livuchi", "Yuqoriga chiqadigan yo'l", "Nuh", "Jin", "O'ranib yotuvchi", "Burkanib yotuvchi", "Qiyomat", "Inson", "Yuborilganlar", "Muhim xabar", "Sug'urib oluvchilar", "Yuz burishtirdi", "Takvir", "Yorilish", "O'lchovdan urib qoluvchilar", "Inshiqoq", "Burglar", "Kechasi keluvchi", "Oliy qadar", "O'rab bosib oluvchi", "Erta tong", "Shahar", "Quyosh", "Tun", "Choshgoh payti", "Kengaytirish", "Anjir", "Zuluk", "Qadr", "Dalil", "Zilzila", "Chopuvchilar", "Shiddat bilan qoquvchi", "Takaasur", "Asr", "G'iybat ila odamlarning obro'sini ko'p to'kkuvchi", "Fil", "Quraysh", "Maa'uun", "Ko'p yaxshilik", "Kofirlar", "Nusrat", "Arqon", "Ixlos", "Subh", "Odamlar", "   "};
    int[] images = {R.drawable.infoblue,R.drawable.fatiha, R.drawable.baqara, R.drawable.oliimron, R.drawable.niso, R.drawable.moida, R.drawable.anom, R.drawable.arof, R.drawable.anfol, R.drawable.tavba, R.drawable.yunus, R.drawable.hud, R.drawable.yusuf, R.drawable.rod, R.drawable.ibrohiym1, R.drawable.hijr, R.drawable.nahl, R.drawable.isro, R.drawable.kahf, R.drawable.maryam, R.drawable.toha, R.drawable.anbiyo, R.drawable.haj, R.drawable.muminun, R.drawable.nur, R.drawable.furqon, R.drawable.shuaro, R.drawable.naml, R.drawable.qosos, R.drawable.ankabut, R.drawable.rum, R.drawable.luqmon, R.drawable.sajda, R.drawable.ahzob, R.drawable.saba, R.drawable.fotir, R.drawable.yasin, R.drawable.soffat, R.drawable.sod, R.drawable.zumar, R.drawable.gofir, R.drawable.fussilat, R.drawable.shuuro, R.drawable.zuxruf, R.drawable.duxon, R.drawable.josiya, R.drawable.ahqof, R.drawable.muhammad, R.drawable.fath, R.drawable.hujorot, R.drawable.qof, R.drawable.zaariyaat, R.drawable.tur, R.drawable.najm, R.drawable.qamar, R.drawable.arrohman, R.drawable.voqea, R.drawable.hadid, R.drawable.mujodala, R.drawable.hashr, R.drawable.mumtahana, R.drawable.soff, R.drawable.jumua, R.drawable.munofiqun, R.drawable.tagobun, R.drawable.taloq, R.drawable.tahrim, R.drawable.mulk, R.drawable.qolam, R.drawable.haaqqoh, R.drawable.maorij, R.drawable.nuh, R.drawable.jin, R.drawable.muzzammil, R.drawable.muddassir, R.drawable.qiyaama, R.drawable.insan, R.drawable.mursalaat, R.drawable.naba, R.drawable.naziaat, R.drawable.abasa, R.drawable.takvir, R.drawable.infitor, R.drawable.mutoffifun, R.drawable.inshiqoq, R.drawable.buruj, R.drawable.toriq, R.drawable.aala, R.drawable.goshiah, R.drawable.fajr, R.drawable.balad, R.drawable.shams, R.drawable.layl, R.drawable.zuho, R.drawable.sharh, R.drawable.tiyn, R.drawable.alaq, R.drawable.qadr, R.drawable.bayyina, R.drawable.zalzala, R.drawable.adiat, R.drawable.qoria, R.drawable.takaasur, R.drawable.asr, R.drawable.humaza, R.drawable.fil, R.drawable.quraysh, R.drawable.maauun, R.drawable.kavsar, R.drawable.kafiruun, R.drawable.nasr, R.drawable.masad, R.drawable.ixlos, R.drawable.falaq, R.drawable.naas, R.color.color3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suralist);

        listView = findViewById(R.id.list_sura);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);

        arrayList = new ArrayList<>();
        Field[] fields = R.raw.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            arrayList.add(fields[i].getName());
        }
        listView.setOnItemClickListener(this);

    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.igSuralogo);
            TextView myTitle = row.findViewById(R.id.tvMaintitle);
            TextView myDescription = row.findViewById(R.id.tvSubtitle);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);


            return row;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, "onItemClick: clicked" );
        Intent intent = null;
        Sura.initialize();

        if (position == 0) {
            intent = new Intent(this, MediaPlayerActivity.class);
        }

//        intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, sura.getSura(position), 0, true, true);


//        if (position == 0) {
//            Toast.makeText(SuraList.this, "Fotiha", Toast.LENGTH_LONG).show();
//
//        }
//        if (position == 1) {
//            Toast.makeText(SuraList.this, "Baqara", Toast.LENGTH_LONG).show();
//            intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, Sura.AL_BAQARA,0,true,false);
//        }
//        if (position == 2) {
//            Toast.makeText(SuraList.this, "Oli Imron", Toast.LENGTH_LONG).show();
//            intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, Sura.OLI_IMRON,0,true,false);
//
//        }
//        if (position == 3) {
//            Toast.makeText(SuraList.this, "Niso", Toast.LENGTH_LONG).show();
//            intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, Sura.AN_NISO,0,true,false);
//
//        }
//        if (position == 4) {
//            Toast.makeText(SuraList.this, "Moida", Toast.LENGTH_LONG).show();
//            intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, Sura.AL_MOIDA,0,true,false);
//
//        }
//        if (position == 5) {
//            Toast.makeText(SuraList.this, "An'om", Toast.LENGTH_LONG).show();
//            intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, Sura.AL_ANOM,0,true,false);
//
//        }
//        if (position == 6) {
//            Toast.makeText(SuraList.this, "A'rof", Toast.LENGTH_LONG).show();
//            intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, Sura.AL_AROF,0,true,false);
//
//        }
//        if (position == 7) {
//            Toast.makeText(SuraList.this, "Anfol", Toast.LENGTH_LONG).show();
//            intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, Sura.AL_ANFOL,0,true,false);
//
//        }
//, "Tavba", "Yunus", "Hud", "Yusuf", "Ro'd", "Ibrohim", "Hijr", "Nahl", "Isro", "Kahf", "Maryam", "Toha", "Anbiyo", "Haj", "Mu'minun", "Nur", "Furqon", "Shuaro", "Naml", "Qosos", "Ankabut", "Rum", "Luqmon", "Sajda", "Ahzob", "Saba'", "Fotir", "Yaasiyn", "Soffat", "Sod", "Zumar", "G'ofir", "Fussilat", "Shuuro", "Zuxruf", "Duxon", "Josiya", "Ahqof", "Muhammad", "Fath", "Hujurot", "Qof", "Zoriyot", "Tur", "Najm", "Qamar", "Ar-Rohman", "Voqi'a", "Hadid", "Mujodala", "Hashr", "Mumtahana", "Sooff", "Juma", "Munofiqun", "Tag'obun", "Taloq", "Tahrim", "Mulk", "Qalam", "Haaqqo", "Ma'orij", "Nuh", "JIn", "Muzzammil", "Muddassir", "Qiyaama", "Inson", "Mursalat", "Naba'", "Nazi'aat", "Abasa", "Takvir", "Infitor", "Mutoffifun", "Inshiqoq", "Buruj", "Toriq", "A'laa", "G'oshiya", "Fajr", "Balad", "SHams", "Layl", "Zuho", "Sharh", "Tiyn", "Alaq", "Qadr", "Bayyina", "Zalzala", "A'diyat", "Qori'a", "Takaasur", "Asr", "Humaza", "Fiyl", "Quraysh", "Maa'uun", "Kavsar", "Kaafirun", "Nasr", "Masad", "Ixlos", "Falaq", "Naas"
        if (intent != null) {
            startActivity(intent);
        }
    }
}

