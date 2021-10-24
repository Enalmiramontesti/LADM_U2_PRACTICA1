package tepic.tecnm.mx.ladm_u2_practica1_presentaciondiamuertos

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.media.MediaPlayer
import android.os.CountDownTimer
import android.view.View

class Lienzo(p:MainActivity):View(p) {

    //Declaracion de variables
    var principal = p
    val tumba = BitmapFactory.decodeResource(principal.resources,R.drawable.tumba)
    val altar = BitmapFactory.decodeResource(principal.resources,R.drawable.altarmuertos)
    val cabeza = BitmapFactory.decodeResource(principal.resources,R.drawable.cabeza)
    val papel = BitmapFactory.decodeResource(principal.resources,R.drawable.papel)
    val catrin = BitmapFactory.decodeResource(principal.resources, R.drawable.catrin)
    var catrina = BitmapFactory.decodeResource(principal.resources, R.drawable.catrina)
    val letra = BitmapFactory.decodeResource(principal.resources, R.drawable.letras)
    val vela = BitmapFactory.decodeResource(principal.resources, R.drawable.vela)
    val tumba2 =  BitmapFactory.decodeResource(principal.resources,R.drawable.tumba2)
    val esqueleto = BitmapFactory.decodeResource(principal.resources,R.drawable.lunacalavera)
    val catrina2 = BitmapFactory.decodeResource(principal.resources,R.drawable.catrina2)
    var posxCatrina = 1190f
    var vaboolean = true

    val moverCatrina = object : CountDownTimer(2000,50){
        override fun onTick(millisUntilFinished: Long) {

            if(posxCatrina > 500 && vaboolean) {
                posxCatrina -= 2
            } else {
                vaboolean = false
                catrina = BitmapFactory.decodeResource(principal.resources, R.drawable.catrinavolteada)
            }

            if (posxCatrina <= 1190 && !vaboolean ) {
                posxCatrina += 2
            }else {
                vaboolean = true
                catrina = BitmapFactory.decodeResource(principal.resources, R.drawable.catrina)
            }

            invalidate()
        }

        override fun onFinish() {
            start()
        }

    }

    init {
        moverCatrina.start()

    }


    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        c.drawARGB(255,5,31,49,)
        val p = Paint()
        //Luna
        p.color = Color.argb(255,238,221,165)
        c.drawCircle(640f, 200f, 70f,p)
        p.color = Color.argb(255,15,16,43)

        //esqueleto en luna
        c.drawBitmap(esqueleto,350f,250f,p)


        //Montes
        p.color = Color.argb(255,9,20,24)
        c.drawOval(-100f,-100f,150f,700f,p)
        c.drawOval(-100f,600f,150f,1480f,p)

        //Nubes
        p.color = Color.argb(254,152,152,152)
        c.drawOval(500f,20f,600f,300f,p)
        c.drawOval(500f,170f,600f,430f,p)

        //arbol 1
        p.color = Color.argb(255,46,5,2)
        c.drawRect(150f,90f,0f,160f,p)
        //Hoja
        p.color = Color.argb(255,7,65,56)
        c.drawOval(150f,5f,230f,240f,p)
        c.drawOval(220f,5f,300f,240f,p)

        //arbol 2
        p.color = Color.argb(255,46,5,2)
        c.drawRect(150f,1030f,0f,1130f,p)
        //Hoja
        p.color = Color.argb(255,7,65,56)
        c.drawOval(150f,940f,280f,1230f,p)
        c.drawOval(250f,940f,380f,1230f,p)

        //Imagenes
        c.drawBitmap(tumba,70f,245f,p)
        c.drawBitmap(tumba,10f,180f,p)
        c.drawBitmap(tumba,70f,900f,p)
        c.drawBitmap(tumba2,120f,850f,p)
        c.drawBitmap(tumba,36f,810f,p)
        c.drawBitmap(tumba2,80f,1190f,p)
        c.drawBitmap(altar,20f,430f,p)
        c.drawBitmap(cabeza,200f,95f,p)
        c.drawBitmap(papel,100f, 35f,p)
        c.drawBitmap(papel,100f, 150f,p)
        c.drawBitmap(papel,100f, 1130f,p)
        c.drawBitmap(papel,100f, 1000f,p)
        c.drawBitmap(letra, 400f,500f,p)
        c.drawBitmap(vela,0f,1130f,p)
        c.drawBitmap(vela,0f,950f,p)

        //catrines
        c.drawBitmap(catrin,0f, 300f,p)
        c.drawBitmap(catrina2,200f,1050f,p)
        c.drawBitmap(catrina,-15f,posxCatrina,p)

    }

}