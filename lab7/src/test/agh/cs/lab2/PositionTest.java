package agh.cs.lab2;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PositionTest {
    @Test
    public void toStringTest(){
        assertEquals ("(1,1)", new agh.cs.lab2.Position(1,1).toString());
    }



}
