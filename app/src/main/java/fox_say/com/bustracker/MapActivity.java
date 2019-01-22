package fox_say.com.bustracker;

import android.app.Activity;
import android.os.Bundle;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

public class MapActivity extends Activity {

    private final String MAPKIT_API_KEY = "e2fea7a9-9b0e-437e-b234-1cb35d6f9f5e";
    private final Point TARGET_LOCATION = new Point(59.945933, 30.320045);

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MapKitFactory.setApiKey(MAPKIT_API_KEY);

        MapKitFactory.initialize(this);
        setContentView(R.layout.fragment_map);
        super.onCreate(savedInstanceState);
        mapView = (MapView) findViewById(R.id.mapView);

        // Перемещение камеры в центр Санкт-Петербурга.
        mapView.getMap().move(
                new CameraPosition(TARGET_LOCATION, 14.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 5),
                null);
    }

    @Override
    protected void onStop() {
        super.onStop();
        MapKitFactory.getInstance().onStop();
        mapView.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }
}
