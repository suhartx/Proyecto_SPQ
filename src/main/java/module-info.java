module org.BGS006 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.jdo;
    requires jersey.container.grizzly2.http;
    requires jersey.common;
    requires grizzly.http.server;
    requires jersey.server;
    requires java.ws.rs;
    requires java.sql;
    requires java.desktop;

    opens org.BGS006 to javafx.fxml;
    exports org.BGS006;
}
