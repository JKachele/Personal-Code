/******************************************
 *Project-------Engine2D-LWJGL
 *File----------Gravity2D.java
 *Author--------Justin Kachele
 *Date----------10/18/2022
 *License-------Mozilla Public License Version 2.0
 ******************************************/
package com.jkachele.game.physics2dtmp.forces;

import com.jkachele.game.physics2dtmp.rigidbody.Rigidbody2D;
import org.joml.Vector2f;

public class Gravity2D implements ForceGenerator{
    private Vector2f gravity;

    public Gravity2D(Vector2f gravity) {
        this.gravity = new Vector2f(gravity);
    }

    @Override
    public void updateForce(Rigidbody2D rigidbody, float dt) {
        rigidbody.addForce(new Vector2f(gravity).mul(rigidbody.getMass()));
    }
}
