
package com.malicine.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ScrollView;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setBackgroundColor(Color.rgb(15, 15, 20));
        main.setPadding(20, 25, 20, 20);

        TextView logo = new TextView(this);
        logo.setText("🎬 MALI CINE");
        logo.setTextSize(28);
        logo.setTextColor(Color.WHITE);
        logo.setGravity(Gravity.CENTER);
        main.addView(logo);

        TextView subtitle = new TextView(this);
        subtitle.setText("Vos films préférés, au même endroit");
        subtitle.setTextColor(Color.LTGRAY);
        subtitle.setTextSize(14);
        subtitle.setGravity(Gravity.CENTER);
        main.addView(subtitle);

        EditText search = new EditText(this);
        search.setHint("Rechercher un film...");
        search.setTextColor(Color.WHITE);
        search.setHintTextColor(Color.GRAY);
        main.addView(search);

        ScrollView scroll = new ScrollView(this);
        LinearLayout content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);

        TextView title = new TextView(this);
        title.setText("Explorer les films");
        title.setTextSize(22);
        title.setTextColor(Color.WHITE);
        title.setPadding(0, 25, 0, 15);
        content.addView(title);

        String[] categories = {
            "🔥 Tendances",
            "🎬 Films maliens",
            "😂 Comédie",
            "💥 Action",
            "❤️ Romance",
            "👻 Horreur",
            "📺 Séries"
        };

        for (String category : categories) {
            TextView item = new TextView(this);
            item.setText(category);
            item.setTextSize(18);
            item.setTextColor(Color.WHITE);
            item.setPadding(15, 18, 15, 18);
            content.addView(item);
        }

        scroll.addView(content);
        main.addView(scroll);

        setContentView(main);
    }
                     }
