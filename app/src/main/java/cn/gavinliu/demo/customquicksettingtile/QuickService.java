package cn.gavinliu.demo.customquicksettingtile;

import android.content.Intent;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.util.Log;

/**
 * Created by Gavin on 2016/08/04.
 */
public class QuickService extends TileService {

    public static final String TAG = QuickService.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onDestroy");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStartListening() {
        super.onStartListening();
        Log.d(TAG, "onStartListening");
        Tile tile = getQsTile();
        if (tile != null) {
            if (tile.getState() == Tile.STATE_ACTIVE) {
                tile.setLabel("Running...");
            } else {
                tile.setLabel("QuickStart");
            }
            tile.updateTile();
        }
    }

    @Override
    public void onStopListening() {
        super.onStopListening();
        Log.d(TAG, "onStopListening");
    }

    @Override
    public void onTileAdded() {
        super.onTileAdded();
        Log.d(TAG, "onTileAdded");
        Tile tile = getQsTile();
        if (tile != null) {
            Log.d(TAG, "getQsTile");
        }
    }

    @Override
    public void onTileRemoved() {
        super.onTileRemoved();
        Log.d(TAG, "onTileRemoved");
    }

    @Override
    public void onClick() {
        super.onClick();
        Log.d(TAG, "onClick");

        Tile tile = getQsTile();
        if (tile != null) {
            if (tile.getState() == Tile.STATE_ACTIVE) {
                tile.setLabel("QuickStart");
                tile.setState(Tile.STATE_INACTIVE);
            } else {
                tile.setLabel("Running...");
                tile.setState(Tile.STATE_ACTIVE);
            }

            tile.updateTile();
        }
    }

}
