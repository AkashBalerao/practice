package DesignPatterns;

class Shirt {
    int length;
    int noOfButtons;

    public int getLength() {
        return length;
    }

    public int getNoOfButtons() {
        return noOfButtons;
    }
}

class SimpleShirt extends Shirt {
    SimpleShirt() {
        this.length = 10;
        this.noOfButtons = 10;
    }
}

abstract class ShirtDecorator extends Shirt {
    protected Shirt shirt; // Wrapped object

    ShirtDecorator(Shirt shirt) {
        this.shirt = shirt;
    }

    public int getLength() {
        return shirt.getLength();
    }

    public int getNoOfButtons() {
        return shirt.getNoOfButtons();
    }
}

class MoreLength extends ShirtDecorator {
    private int extraLength;

    MoreLength(Shirt shirt, int extraLength) {
        super(shirt);
        this.extraLength = extraLength;
    }

    public int getLength() {
        return super.getLength() + extraLength;
    }
}

class MoreButtons extends ShirtDecorator {
    private int extraButtons;

    MoreButtons(Shirt shirt, int extraButtons) {
        super(shirt);
        this.extraButtons = extraButtons;
    }

    public int getNoOfButtons() {
        return super.getNoOfButtons() + extraButtons;
    }
}

public class DecoretorPattern {
    public static void main(String[] args) {
        Shirt myShirt = new SimpleShirt();
        System.out.println("Original Length: " + myShirt.getLength());
        System.out.println("Original Buttons: " + myShirt.getNoOfButtons());

        myShirt = new MoreLength(myShirt, 5);
        System.out.println("After More Length, Length: " + myShirt.getLength());

        myShirt = new MoreButtons(myShirt, 3);
        System.out.println("After More Buttons, No of Buttons: " + myShirt.getNoOfButtons());
    }
}
