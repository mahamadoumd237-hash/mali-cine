
package com.malicine.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.*;

public class MainActivity extends Activity {

    int fond = Color.rgb(12, 10, 22);
    int violet = Color.rgb(160, 75, 255);
    String[] films = {
    "Le dernier baobab",
    "Les secrets de Bamako",
    "Cœur du Sahel",
    "Action au Mali",
    "Amour et destin",
    "The Blacklist - Raymond Reddington"
};

String[] genres = {
    "Drame", "Drame", "Romance",
    "Action", "Romance", "Série policière"
};

String[] emojis = {
    "🌳", "🌆", "❤️", "💥", "💕", "🕴️"
};

    LinearLayout listeFilms;

    int dp(int v) {
        return (int)(v * getResources().getDisplayMetrics().density);
    }

    GradientDrawable carte(int couleur) {
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(couleur);
        bg.setCornerRadius(dp(14));
        return bg;
    }

    TextView texte(String s, int taille, int couleur) {
        TextView t = new TextView(this);
        t.setText(s);
        t.setTextSize(taille);
        t.setTextColor(couleur);
        return t;
    }

    void afficherFilms(String recherche) {
        listeFilms.removeAllViews();
        boolean trouve = false;

        for (int i = 0; i < films.length; i++) {
            if (films[i].toLowerCase().contains(recherche.toLowerCase())
                || genres[i].toLowerCase().contains(recherche.toLowerCase())) {

                trouve = true;

                TextView item = texte(
                    emojis[i] + "   " + films[i] + "\n" + genres[i],
                    18, Color.WHITE
                );
                item.setPadding(dp(16), dp(20), dp(16), dp(20));
                item.setBackground(carte(Color.rgb(42, 28, 58)));

                LinearLayout.LayoutParams p =
                    new LinearLayout.LayoutParams(-1, -2);
                p.setMargins(0, dp(5), 0, dp(5));
                listeFilms.addView(item, p);
            }
        }

        if (!trouve) {
            TextView vide = texte(
                "Aucun film trouvé", 16, Color.LTGRAY);
            vide.setPadding(0, dp(20), 0, dp(20));
            listeFilms.addView(vide);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout main = new LinearLayout(this);
        main.setOrientation(1);
        main.setPadding(dp(16), dp(25), dp(16), dp(20));
        main.setBackgroundColor(fond);

        TextView logo = texte("🎬 MALI CINE", 30, Color.WHITE);
        logo.setGravity(Gravity.CENTER);
        logo.setTypeface(null, Typeface.BOLD);
        main.addView(logo);

        TextView sousTitre = texte(
            "Le cinéma à portée de main", 15, Color.LTGRAY);
        sousTitre.setGravity(Gravity.CENTER);
        sousTitre.setPadding(0, dp(8), 0, dp(20));
        main.addView(sousTitre);

        EditText recherche = new EditText(this);
        recherche.setSingleLine(true);
        recherche.setHint("🔍 Rechercher un film ou genre...");
        recherche.setTextColor(Color.WHITE);
        recherche.setHintTextColor(Color.LTGRAY);
        recherche.setBackground(carte(Color.rgb(38, 28, 52)));
        main.addView(recherche);

        ScrollView scroll = new ScrollView(this);
        LinearLayout contenu = new LinearLayout(this);
        contenu.setOrientation(1);

        TextView titre = texte("🔥 Films populaires", 23, violet);
        titre.setTypeface(null, Typeface.BOLD);
        titre.setPadding(0, dp(25), 0, dp(15));
        contenu.addView(titre);

        listeFilms = new LinearLayout(this);
        listeFilms.setOrientation(1);
        contenu.addView(listeFilms);

        afficherFilms("");

        recherche.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {}

            public void onTextChanged(
                CharSequence s, int start, int before, int count) {
                afficherFilms(s.toString());
            }

            public void afterTextChanged(Editable e) {}
        });

        scroll.addView(contenu);
        main.addView(scroll);
        setContentView(main);
    }
}
