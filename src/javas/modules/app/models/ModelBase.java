package javas.modules.app.models;

import java.util.UUID;

public class ModelBase {
    private String _id;
    public ModelBase(String _id) {
        this._id = _id;
        if (this._id == null) {
            this._id = UUID.randomUUID().toString();
        }
    }

    public String getId(){
        return this._id;
    }

    public void setId(String _id) {
        this._id = _id;
    }
}
