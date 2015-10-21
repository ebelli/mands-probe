package com.ebelli.mandsprobe.model;

/**
 * POJO for the laste tracked movements of the alien space ship
 */
public class Directions {
    private String[] Directions;

    public String[] getDirections ()
    {
        return Directions;
    }

    public void setDirections (String[] Directions)
    {
        this.Directions = Directions;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Directions = "+Directions+"]";
    }
}
