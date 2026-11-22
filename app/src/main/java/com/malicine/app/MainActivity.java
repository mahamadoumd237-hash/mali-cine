
package com.malicine.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.*;

public class MainActivity extends Activity {

    int fond = Color.rgb(12, 10, 22);
    int violet = Color.rgb(160, 75, 255);

    int dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density);
    }

    GradientDrawable carte(int couleur) {
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(couleur);
        bg.setCornerRadius(dp(14));
        return bg;
    }

    TextView texte(String value, int taille, int couleur) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(taille);
        t.setTextColor(couleur);
        return t;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout main = new LinearLayout(this);
        main.setOrientation(1);
        main.setBackgroundColor(fond);

        ScrollView scroll = new ScrollView(this);
        LinearLayout contenu = new LinearLayout(this);
        contenu.setOrientation(1);
        contenu.setPadding(dp(16), dp(25), dp(16), dp(25));

        TextView logo = texte("🎬 MALI CINE", 30, Color.WHITE);
        logo.setGravity(Gravity.CENTER);
        logo.setTypeface(null, Typeface.BOLD);
        contenu.addView(logo);

        TextView sousTitre = texte(
            "Le cinéma à portée de main", 15, Color.LTGRAY);
        sousTitre.setGravity(Gravity.CENTER);
        sousTitre.setPadding(0, dp(8), 0, dp(20));
        contenu.addView(sousTitre);

        EditText recherche = new EditText(this);
        recherche.setSingleLine(true);
        recherche.setHint("🔍 Rechercher un film...");
        recherche.setTextColor(Color.WHITE);
        recherche.setHintTextColor(Color.LTGRAY);
        recherche.setBackground(carte(Color.rgb(38, 28, 52)));
        contenu.addView(recherche);

        TextView vedette = texte("⭐ FILM À LA UNE", 23, violet);
        vedette.setTypeface(null, Typeface.BOLD);
        vedette.setPadding(0, dp(25), 0, dp(15));
        contenu.addView(vedette);

        TextView affiche = texte(
            "🍿\nMALI CINE\n\nDécouvrez votre prochain film préféré",
            22, Color.WHITE);
        affiche.setGravity(Gravity.CENTER);
        affiche.setPadding(dp(15), dp(35), dp(15), dp(35));
        affiche.setBackground(carte(Color.rgb(65, 30, 100)));
        contenu.addView(affiche);

        TextView populaire = texte("🔥 Films populaires", 23, Color.WHITE);
        populaire.setTypeface(null, Typeface.BOLD);
        populaire.setPadding(0, dp(28), 0, dp(15));
        contenu.addView(populaire);

        String[] films = {
            "LE DERNIER BAOBAB",
            "LES SECRETS DE BAMAKO",
            "CŒUR DU SAHEL"
        };

        String[] emojis = {"🌳", "🌆", "❤️"};
        int[] couleurs = {
            Color.rgb(35, 85, 65),
            Color.rgb(65, 35, 100),
            Color.rgb(110, 35, 65)
        };

        LinearLayout ligne = new LinearLayout(this);
        ligne.setOrientation(0);

        for (int i = 0; i < films.length; i++) {
            LinearLayout poster = new LinearLayout(this);
            poster.setOrientation(1);
            poster.setGravity(Gravity.CENTER);
            poster.setPadding(dp(8), dp(12), dp(8), dp(12));
            poster.setBackground(carte(couleurs[i]));

            TextView image = texte(emojis[i], 42, Color.WHITE);
            image.setGravity(Gravity.CENTER);
            poster.addView(image);

            TextView nom = texte(films[i], 13, Color.WHITE);
            nom.setTypeface(null, Typeface.BOLD);
            nom.setGravity(Gravity.CENTER);
            nom.setPadding(0, dp(12), 0, dp(10));
            poster.addView(nom);

            TextView bouton = texte("▶ Regarder", 13, Color.WHITE);
            bouton.setGravity(Gravity.CENTER);
            bouton.setPadding(dp(8), dp(8), dp(8), dp(8));
            bouton.setBackground(carte(violet));
            poster.addView(bouton);

            LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(0, dp(175), 1);
            params.setMargins(dp(3), 0, dp(3), 0);
            ligne.addView(poster, params);
        }

        contenu.addView(ligne);

        TextView categories = texte(
            "🎭 Explorer les catégories", 22, Color.WHITE);
        categories.setPadding(0, dp(30), 0, dp(15));
        contenu.addView(categories);

        String[] noms = {
            "🔥 Tendances",
            "🎬 Films maliens",
            "😂 Comédie",
            "💥 Action",
            "❤️ Romance",
            "👻 Horreur",
            "📺 Séries"
        };

        for (String nom : noms) {
            TextView item = texte(nom, 18, Color.WHITE);
            item.setPadding(dp(16), dp(17), dp(16), dp(17));
            item.setBackground(carte(Color.rgb(38, 28, 52)));

            LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(-1, -2);
            p.setMargins(0, dp(4), 0, dp(4));
            contenu.addView(item, p);
        }

        scroll.addView(contenu);
        main.addView(scroll);
        setContentView(main);
    }
                                           }
