module com.gccfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires json.simple;

    opens com.gccfx to javafx.fxml;
    exports com.gccfx;
    exports com.gccfx.Controllers;
    opens com.gccfx.Controllers to javafx.fxml;
}