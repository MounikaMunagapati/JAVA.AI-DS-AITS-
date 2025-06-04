import java.util.Stack;
public class BrowserHistory {
    private final Stack<String> Stack1 = new Stack<>();
    private final Stack<String> Stack2 = new Stack<>();
    private String currentPage = "Home";
    public void visit(String url) {
        Stack1.push(currentPage);
        currentPage = url;
        Stack2.clear();
        log("Visited: " + url);
    }
    public void back() {
        if (!Stack1.isEmpty()) {
            Stack2.push(currentPage);
            currentPage = Stack1.pop();
            log("Back to: " + currentPage);
        } else {
            log("No pages to go back to.");
        }
    }
    public void forward() {
        if (!Stack2.isEmpty()) {
            Stack1.push(currentPage);
            currentPage = Stack2.pop();
            log("Forward to: " + currentPage);
        } else {
            log("No pages to go forward to.");
        }
    }
    public void showCurrentPage() {
        log("Current page: " + currentPage);
    }
    private void log(String message) {
        System.out.println(message);
    }
    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory();
        browser.showCurrentPage();
        browser.visit("https://google.com");
        browser.visit("https://github.com");
        browser.visit("https://stackoverflow.com");
        browser.back();  
        browser.back();  
        browser.forward();  
        browser.visit("https://openai.com");
        browser.forward(); 
        browser.showCurrentPage();
    }
}