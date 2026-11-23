
package com.malicine.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    int fond = Color.rgb(12, 10, 22);
    int violet = Color.rgb(160, 75, 255);
    int blanc = Color.WHITE;
    LinearLayout listeFilms;

    String categorie = "Tous";

    String[] films = {
        "The Blacklist",
        "John Wick",
        "Extraction",
        "Le dernier baobab",
        "Les secrets de Bamako",
        "Cœur du Sahel",
        "Action au Mali",
        "Amour et destin"
    };

    String[] genres = {
        "Série", "Action", "Action", "Drame",
        "Drame", "Romance", "Action", "Romance"
    };

    String[] descriptions = {
        "Raymond Reddington, un criminel recherché, se livre au FBI et propose de collaborer avec les autorités.",
        "Un ancien tueur à gages reprend les armes pour se venger.",
        "Un mercenaire part en mission dangereuse pour sauver un jeune garçon.",
        "Une histoire au cœur du Mali.",
        "Des secrets, des mystères et des histoires de Bamako.",
        "Une histoire d'amour et de vie au Sahel.",
        "Une aventure pleine d'action au Mali.",
        "Une histoire d'amour et de destin."
    };

    int dp(int v) {
        return (int) (v * getResources().getDisplayMetrics().density);
    }

    GradientDrawable carte(int couleur, int rayon) {
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(couleur);
        bg.setCornerRadius(dp(rayon));
        return bg;
    }

    TextView texte(String s, int taille, int couleur) {
        TextView t = new TextView(this);
        t.setText(s);
        t.setTextSize(taille);
        t.setTextColor(couleur);
        return t;
    }

    void afficherDetails(int i) {
        new AlertDialog.Builder(this)
            .setTitle(films[i])
            .setMessage("Catégorie : " + genres[i]
                + "\n\n" + descriptions[i])
            .setPositiveButton("Fermer", null)
            .show();
    }

    
void afficherFilms(String recherche) {
    listeFilms.removeAllViews();

    String[] dessins = {
        "🤖", "🥷", "🚀", "🌳",
        "🏙️", "❤️", "⚔️", "🌹"
    };

    int[] couleurs = {
        Color.rgb(20, 70, 130),
        Color.rgb(90, 20, 120),
        Color.rgb(0, 100, 130),
        Color.rgb(20, 100, 60),
        Color.rgb(120, 50, 20),
        Color.rgb(150, 20, 80),
        Color.rgb(120, 30, 20),
        Color.rgb(100, 20, 100)
    };

    boolean trouve = false;
    int position = 0;
    LinearLayout ligne = null;

    for (int i = 0; i < films.length; i++) {

        boolean rechercheOK =
            films[i].toLowerCase().contains(recherche.toLowerCase())
            || genres[i].toLowerCase().contains(recherche.toLowerCase());

        boolean categorieOK =
            categorie.equals("Tous")
            || genres[i].equalsIgnoreCase(categorie);

        if (rechercheOK && categorieOK) {
            trouve = true;

            if (position % 2 == 0) {
                ligne = new LinearLayout(this);
                ligne.setOrientation(0);
                listeFilms.addView(ligne,
                    new LinearLayout.LayoutParams(-1, -2));
            }

            final int index = i;

            LinearLayout carteFilm = new LinearLayout(this);
            carteFilm.setOrientation(1);
            carteFilm.setPadding(dp(6), dp(6), dp(6), dp(10));
            carteFilm.setBackground(carte(Color.rgb(30, 25, 40), 14));

            LinearLayout.LayoutParams cp =
                new LinearLayout.LayoutParams(0, -2, 1);
            cp.setMargins(dp(4), dp(6), dp(4), dp(6));

            TextView affiche = texte(
                dessins[i] + "\n\nMALI CINÉ", 30, blanc);
            affiche.setGravity(Gravity.CENTER);
            affiche.setTypeface(null, Typeface.BOLD);
            affiche.setBackground(carte(couleurs[i], 12));
            affiche.setLayoutParams(
                new LinearLayout.LayoutParams(-1, dp(175)));

            TextView titre = texte(films[i], 16, blanc);
            titre.setGravity(Gravity.CENTER);
            titre.setTypeface(null, Typeface.BOLD);
            titre.setPadding(0, dp(8), 0, dp(5));

            TextView genre = texte(genres[i], 12, violet);
            genre.setGravity(Gravity.CENTER);

            TextView bouton = texte("▶ Regarder", 14, blanc);
            bouton.setGravity(Gravity.CENTER);
            bouton.setPadding(0, dp(8), 0, dp(8));
            bouton.setBackground(carte(violet, 20));

            carteFilm.addView(affiche);
            carteFilm.addView(titre);
            carteFilm.addView(genre);
            carteFilm.addView(bouton);

            carteFilm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    afficherDetails(index);
                }
            });

            ligne.addView(carteFilm, cp);
            position++;
        }
    }

    if (!trouve) {
        TextView vide = texte("Aucun film trouvé", 16, blanc);
        vide.setGravity(Gravity.CENTER);
        listeFilms.addView(vide);
    }

    if (position % 2 != 0 && ligne != null) {
        ligne.addView(new View(this),
            new LinearLayout.LayoutParams(0, 1, 1));
    }
                                 }
    
    }
    void lireVideo(String adresseVideo) {
    VideoView lecteur = new VideoView(this);

    MediaController controles = new MediaController(this);
    controles.setAnchorView(lecteur);

    lecteur.setMediaController(controles);
    lecteur.setVideoURI(android.net.Uri.parse(adresseVideo));

    setContentView(lecteur);
    lecteur.start();
    }

    void ajouterCategorie(
        LinearLayout ligne, String nom, EditText recherche) {

        TextView bouton = texte(nom, 14, blanc);
        bouton.setGravity(Gravity.CENTER);
        bouton.setPadding(dp(16), dp(10), dp(16), dp(10));
        bouton.setBackground(carte(violet, 20));

        LinearLayout.LayoutParams p =
            new LinearLayout.LayoutParams(-2, -2);

        p.setMargins(0, 0, dp(8), 0);
        ligne.addView(bouton, p);

        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categorie = nom;
                afficherFilms(recherche.getText().toString());
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout main = new LinearLayout(this);
        main.setOrientation(1);
        main.setPadding(dp(16), dp(25), dp(16), dp(10));
        main.setBackgroundColor(fond);

        TextView logo = texte("🎬 MALI CINE", 30, violet);
        logo.setTypeface(null, Typeface.BOLD);
        logo.setGravity(Gravity.CENTER);
        main.addView(logo);

        TextView sousTitre = texte(
            "Votre cinéma dans votre poche", 14, Color.LTGRAY
        );
        sousTitre.setGravity(Gravity.CENTER);
        sousTitre.setPadding(0, dp(5), 0, dp(20));
        main.addView(sousTitre);

        TextView titre = texte(
            "Bienvenue sur Mali Cine", 22, blanc
        );
        titre.setTypeface(null, Typeface.BOLD);
        main.addView(titre);

        EditText recherche = new EditText(this);
        recherche.setSingleLine(true);
        recherche.setHint("🔍 Rechercher un film...");
        recherche.setTextColor(blanc);
        recherche.setHintTextColor(Color.LTGRAY);
        recherche.setPadding(dp(14), dp(10), dp(14), dp(10));
        recherche.setBackground(carte(Color.rgb(40, 30, 55), 14));

        LinearLayout.LayoutParams rechercheParams =
            new LinearLayout.LayoutParams(-1, -2);
        rechercheParams.setMargins(0, dp(18), 0, dp(15));
        main.addView(recherche, rechercheParams);

        HorizontalScrollView horizontal =
            new HorizontalScrollView(this);
        horizontal.setHorizontalScrollBarEnabled(false);

        LinearLayout categories = new LinearLayout(this);
        categories.setOrientation(0);

        ajouterCategorie(categories, "Tous", recherche);
        ajouterCategorie(categories, "Action", recherche);
        ajouterCategorie(categories, "Drame", recherche);
        ajouterCategorie(categories, "Romance", recherche);
        ajouterCategorie(categories, "Série", recherche);

        horizontal.addView(categories);
        main.addView(horizontal);

        TextView populaire = texte(
            "🔥 Films et séries", 21, blanc
        );
        populaire.setTypeface(null, Typeface.BOLD);
        populaire.setPadding(0, dp(22), 0, dp(12));
        main.addView(populaire);

        ScrollView scroll = new ScrollView(this);

        listeFilms = new LinearLayout(this);
        listeFilms.setOrientation(1);

        scroll.addView(listeFilms);
        main.addView(scroll,
            new LinearLayout.LayoutParams(-1, 0, 1));

        afficherFilms("");

        recherche.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(
                CharSequence s, int start, int before, int count) {
                afficherFilms(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        setContentView(main);
    }
                    }
