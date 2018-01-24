import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by Emre CELEBI on 12.09.2017. cLB
 */

public class RecyclerViewTarget {

    private RecyclerView recyclerView;
    private int offsetX;
    private int offsetY;

    private int childViewByID;

    public RecyclerViewTarget(RecyclerView recyclerView, int childViewByID) {
        this.recyclerView = recyclerView;
        this.childViewByID = childViewByID;
    }

    public RecyclerViewTarget(int viewId, int offsetX, int offsetY, RecyclerView recyclerView) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.recyclerView = recyclerView;
    }

    public Point getPoint() {
        int[] location = new int[2];
        View childAt = recyclerView.getChildAt(0);
        childAt.getLocationInWindow(location);
        int x = location[0] + (int) childAt.findViewById(childViewByID).getX() + (dpToPx(50) / 2); // --> 50dp(childview width)
        int y = location[1] + childAt.getHeight() / 2;
        return new Point(x, y);
    }
	
	public  int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
