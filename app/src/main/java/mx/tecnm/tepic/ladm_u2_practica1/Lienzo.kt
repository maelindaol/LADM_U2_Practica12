package mx.tecnm.tepic.ladm_u2_practica1

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.os.CountDownTimer
import android.view.View
import androidx.annotation.RequiresApi
import kotlin.concurrent.timer

class Lienzo(p:MainActivity): View(p){
    var xC = 20f
    var yC = 1650f
    var incrementoX=2
    var bandera=true
    val esqueleto = BitmapFactory.decodeResource(resources,R.drawable.esqueleto)
    val catrina = BitmapFactory.decodeResource(resources,R.drawable.catrina)
    val tumba = BitmapFactory.decodeResource(resources,R.drawable.tumba)
    val masnoche = BitmapFactory.decodeResource(resources,R.drawable.masnoche1)
    val LAPSO =         1
    val TIEMPOTOTAL =   1000
    val timer=object : CountDownTimer(TIEMPOTOTAL.toLong(),LAPSO.toLong()){
        override fun onTick(p0: Long) {
            xC+=incrementoX
            invalidate()
            if(xC<=-40 || xC>=760){
                incrementoX*=-1
            }
        }
        override fun onFinish() {
            start()
        }
    }
    val timer2=object : CountDownTimer(5000,1000){
        override fun onTick(p0: Long) {

        }
        override fun onFinish() {
            timer.start()
            bandera=false
        }
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()
        c.drawARGB(100,0,0,0)
        c.drawBitmap(masnoche,0f,0f,p)
        //NUBE
        p.setColor(Color.argb(90,255,255,255))
        c.drawOval(390f,70f,700f,190f,p)
        p.setColor(Color.rgb(101,175,232))
        c.drawOval(400f,60f,710f,180f,p)
        p.setColor(Color.rgb(101,175,232))
        c.drawOval(40f,40f,350f,160f,p)
        p.setColor(Color.rgb(101,175,232))
        c.drawOval(230f,20f,510f,175f,p)
        //NUBE
        p.setColor(Color.argb(90,255,255,255))
        c.drawOval(240f,240f,530f,390f,p)
        p.setColor(Color.argb(90,255,255,255))
        c.drawOval(180f,190f,450f,300f,p)
        p.setColor(Color.rgb(101,175,232))
        c.drawOval(50f,210f,400f,360f,p)
        p.setColor(Color.rgb(101,175,232))
        c.drawOval(190f,200f,450f,300f,p)
        p.setColor(Color.rgb(101,175,232))
        c.drawOval(240f,230f,540f,380f,p)
        //NUBE
        p.setColor(Color.argb(90,255,255,255))
        c.drawOval(740f,340f,1030f,490f,p)
        p.setColor(Color.rgb(101,175,232))
        c.drawOval(570f,310f,900f,460f,p)
        p.setColor(Color.rgb(101,175,232))
        c.drawOval(740f,330f,1040f,480f,p)
        //LUNA
        p.setColor(Color.rgb(255,255,255))
        c.drawCircle(930f,15f,200f,p)
        //ARBOL
        p.setColor(Color.rgb(135,65,19))
        c.drawRect(240f,660f,320f,900f,p)

        p.setColor(Color.rgb(139,195,74))
        c.drawOval(240f,650f,530f,800f,p)
        p.setColor(Color.rgb(35,85,37))
        c.drawOval(50f,620f,400f,770f,p)
        p.setColor(Color.rgb(35,85,37))
        c.drawOval(190f,600f,450f,710f,p)
        p.setColor(Color.rgb(35,85,37))
        c.drawOval(240f,640f,540f,790f,p)
        //ARBOL
        p.setColor(Color.rgb(135,65,19))
        c.drawRect(740f,860f,840f,1200f,p)
        p.setColor(Color.rgb(139,195,74))
        c.drawOval(750f,850f,1070f,940f,p)
        p.setColor(Color.rgb(35,85,37))
        c.drawOval(700f,800f,1080f,930f,p)

        p.setColor(Color.rgb(35,85,37))
        c.drawOval(590f,710f,910f,890f,p)

        p.setColor(Color.rgb(35,85,37))
        c.drawOval(510f,740f,990f,910f,p)

        c.drawBitmap(tumba,40f,1200f,p)
        c.drawBitmap(tumba,540f,1000f,p)
        c.drawBitmap(esqueleto,10f,1100f,p)
        c.drawBitmap(esqueleto,300f,880f,p)

        c.drawBitmap(catrina,xC,yC,p)
        if (bandera==true){
            timer2.start()
        }


    }
}