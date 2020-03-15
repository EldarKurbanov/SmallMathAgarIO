package smallmath.agario

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Circle
import com.badlogic.gdx.math.Vector2

class CircleHero : Circle() {

    private val velocity = 100f
    private var color = Color.GREEN

    private val target = Vector2()

    init{
        radius = 20f
        x = 200f
        y = 100f
        setTarget(x, y)
    }

    fun draw(shapeRenderer: ShapeRenderer) {
        shapeRenderer.color = color
        shapeRenderer.circle(x, y, radius)
    }

    fun setTarget(x: Float, y: Float) {
        target.x = x
        target.y = y
    }

    fun moveTowards(delta: Float) {
        if(x < target.x) x += velocity*delta
        if(x > target.x) x -= velocity*delta
        if(y < target.y) y += velocity*delta
        if(y > target.y) y -= velocity*delta
    }
}