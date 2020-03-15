package smallmath.agario.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import smallmath.agario.MyAgarIOGame

object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
            config.samples = 3
        LwjglApplication(MyAgarIOGame(), config)
    }
}