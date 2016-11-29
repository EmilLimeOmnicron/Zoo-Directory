package com.csulb.zoo;

/**
 * Created by Emil on 9/29/2016.
 */
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class AnimalDetails extends MainActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoodetail);
        setText(getIntent().getExtras().getString("name"));
        setDescription(getIntent().getExtras().getString("descr"));
        setImage(getIntent().getExtras().getString("img"));
    }

    public void setText(String item) {
        TextView view = (TextView) findViewById(R.id.textView);
        view.setText(getAnimal(item));
    }

    public void setDescription(String item) {
        TextView view = (TextView) findViewById((R.id.textView2));
        view.setText(getDescription(item));
    }

    public void setImage(String item) {
        ImageView view = (ImageView) findViewById(R.id.imageView);
        view.setImageResource(getImage(item));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zoodetail, container, false);
        return view;
    }

    private String getAnimal(String animal) {
        if (animal.toLowerCase().contains("tetsuya 2")) {
            return "Tetsuya 2";
        }
        if (animal.toLowerCase().contains("happy")) {
            return "Happy";
        }
        if (animal.toLowerCase().contains("chopper")) {
            return "Chopper";

        }
        if (animal.toLowerCase().contains("monokuma")) {
            return "Monokuma";

        }
        if (animal.toLowerCase().contains("kyubey")) {
            return "Kyubey";
        }
        return "???";
    }

    private String getDescription(String descr) {
        if (descr.toLowerCase().contains("tetsuya 2")) {
            return "Tetsuya 2 is a dog in the anime Kuroko's Basketball. He was found in a box and was taken in by the Seiren basketball team for having the same eyes as Kuroko.";
        }
        if (descr.toLowerCase().contains("happy")) {
            return "Happy is a flying cat in the anime Fairy Tail. His exact race is an Exceed. Happy is the partner of the Dragon Slayer, Natsu.";
        }
        if (descr.toLowerCase().contains("chopper")) {
            return "Chopper is a reindeer in the anime One Piece. He ate the Human-Human fruit which makes him able to transform into a human hybrid. He joins the Straw Hat Pirates after Luffy helped him.";

        }
        if (descr.toLowerCase().contains("monokuma")) {
            return "Monokuma is a bear from the game Danganronpa. He is the headmaster in Danganronpa 1 and Danganronpa 2." +
                    "He may look harmless, but he is a malicious beast. Known for his upupupu laugh. Don't attack him or he will explode.";

        }
        if (descr.toLowerCase().contains("kyubey")) {
            return "Kyubey is a cat-like creature from the anime Madoka Magica. Even though it looks kawaii, it is very dangerous. " +
                    "If you are given to chance to have a wish granted by it, do not take the chance. Just walk away and hopefully it will stop bothering you.";
        }
        return "???";
    }

    private int getImage(String img) {
        if (img.toLowerCase().contains("tetsuya 2")) {
            return R.drawable.tetsuya_big1;
        }
        if (img.toLowerCase().contains("happy")) {
            return R.drawable.happy_big;
        }
        if (img.toLowerCase().contains("chopper")) {
            return R.drawable.chopper_big;

        }
        if (img.toLowerCase().contains("monokuma")) {
            return R.drawable.monokum_big;

        }
        if (img.toLowerCase().contains("kyubey")) {
            return R.drawable.kyubey_big;
        }
        return 0;
    }
}
