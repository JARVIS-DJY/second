package lay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.view.View;

/**
 * Created by jarvis on 2017/5/6.
 */

public class Myview extends View implements View.OnClickListener{
    private Paint paint =new Paint();
    private float x=0;
    private float y=0;
    private float speedx=90;
    private float speedy=90;
    private float addx=20;
    private float addy=20;
    private boolean flag=false;

    public Myview(Context context) {
        super(context);
        paint.setColor(Color.RED);
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        canvas.drawRect(x,y,speedx+x,speedy+y,paint);
        x+=addx;
        y+=addy;
        if(x<0)
        {
            addx=Math.abs(addx);
        }
        if(y<0)
        {
            addy=Math.abs(addy);
        }
        if(x>getWidth()-speedx)
        {
            addx=-Math.abs(addx);
        }
        if (y>getHeight()-speedy)
        {
            addy=-Math.abs(addy);
        }
    }
    private  Handler  handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            invalidate();
            handler.sendEmptyMessageDelayed(0,50);
        }
    };
    public  void start(){
        if(!flag)
        {
            handler.sendEmptyMessage(0);
            flag=true;
        }
    }
    public void stop(){
        if(flag)
        {
            handler.removeMessages(0);
            flag=false;
        }
    }

    @Override
    public void onClick(View v) {
        if(flag){
            stop();
        }
        else{
            start();
        }
    }
}
