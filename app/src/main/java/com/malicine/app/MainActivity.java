package com.malicine.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.*;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout main = new LinearLayout(this);
        main.setOrientation(1);
        main.setPadding(20, 35, 20, 20);
        main.setBackgroundColor(Color.rgb(12, 10, 22));

        TextView logo = new TextView(this);
        logo.setText("🎬 MALI CINE");
        logo.setTextColor(Color.WHITE);
        logo.setTextSize(30);
        logo.setGravity(Gravity.CENTER);
        main.addView(logo);

        TextView bienvenue = new TextView(this);
        bienvenue.setText("Le cinéma à portée de main");
        bienvenue.setTextColor(Color.LTGRAY);
        bienvenue.setGravity(Gravity.CENTER);
        main.addView(bienvenue);

        EditText recherche = new EditText(this);
        recherche.setHint("Rechercher un film...");
        recherche.setTextColor(Color.WHITE);
        recherche.setHintTextColor(Color.LTGRAY);
        main.addView(recherche);

        TextView vedette = new TextView(this);
        vedette.setText("⭐ FILM À LA UNE");
        vedette.setTextColor(Color.rgb(180, 100, 255));
        vedette.setTextSize(22);
        vedette.setPadding(0, 30, 0, 15);
        main.addView(vedette);

        TextView affiche = new TextView(this);
        affiche.setText("🍿\\n\\nMALI CINE\\n\\nDécouvrez votre prochain film préféré");
        affiche.setTextColor(Color.WHITE);
        affiche.setTextSize(22);
        affiche.setGravity(Gravity.CENTER);
        affiche.setPadding(15, 45, 15, 45);
        affiche.setBackgroundColor(Color.rgb(65, 30, 100));
        main.addView(affiche);

        TextView titre = new TextView(this);
        titre.setText("Explorer les catégories");
        titre.setTextColor(Color.WHITE);
        titre.setTextSize(22);
        titre.setPadding(0, 25, 0, 15);
        main.addView(titre);

        String[] categories = {
            "🔥 Tendances",
            "🎬 Films maliens",
            "😂 Comédie",
            "💥 Action",
            "❤️ Romance",
            "👻 Horreur",
            "📺 Séries"
        };

        for (String categorie : categories) {
            TextView item = new TextView(this);
            item.setText(categorie);
            item.setTextColor(Color.WHITE);
            item.setTextSize(18);
            item.setPadding(18, 20, 18, 20);
            item.setBackgroundColor(Color.rgb(35, 25, 50));

            LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(-1, -2);
            params.setMargins(0, 5, 0, 5);
            main.addView(item, params);
        }

        setContentView(main);
    }
}
