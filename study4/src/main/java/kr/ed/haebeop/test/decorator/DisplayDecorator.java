package kr.ed.haebeop.test.decorator;

// 추상 클래스 구현체
public abstract class DisplayDecorator extends Display {
    private final Display decoratedDisplay;

    public DisplayDecorator(Display decoratedDisplay) {
        this.decoratedDisplay = decoratedDisplay;
    }
    public void draw() {
        decoratedDisplay.draw();
    }
}
