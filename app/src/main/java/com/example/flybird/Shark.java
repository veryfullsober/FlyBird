package com.example.flybird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.example.flybird.GameView.screenRatioX;
import static com.example.flybird.GameView.screenRatioY;

public class Shark {
    public int speed = 20;
    public boolean wasShot = true;
    int x = 0, y, width, height, birdCounter = 1;
    Bitmap shark1, shark2, shark3, shark4;

    Shark(Resources res) {

        shark1 = BitmapFactory.decodeResource(res, R.drawable.maybaykedich1);
        shark2 = BitmapFactory.decodeResource(res, R.drawable.maybaykedich2);
        shark3 = BitmapFactory.decodeResource(res, R.drawable.maybaykedich3);
        shark4 = BitmapFactory.decodeResource(res, R.drawable.maybaykedich4);

        width = shark1.getWidth();
        height = shark1.getHeight();

        width /= 6;
        height /= 6;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        shark1 = Bitmap.createScaledBitmap(shark1, width, height, false);
        shark2 = Bitmap.createScaledBitmap(shark2, width, height, false);
        shark3 = Bitmap.createScaledBitmap(shark3, width, height, false);
        shark4 = Bitmap.createScaledBitmap(shark4, width, height, false);

        y = -height;
    }

    Bitmap getBird () {

        if (birdCounter == 1) {
            birdCounter++;
            return shark1;
        }

        if (birdCounter == 2) {
            birdCounter++;
            return shark2;
        }

        if (birdCounter == 3) {
            birdCounter++;
            return shark3;
        }

        birdCounter = 1;

        return shark4;
    }

    Rect getCollisionShape () {
        return new Rect(x, y, x + width, y + height);
    }
}
