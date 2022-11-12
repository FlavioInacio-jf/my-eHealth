package javas.modules.app.models;

import java.util.Date;
import java.util.UUID;

public class ModelBase {
    private String _id;
    private Date createdAt;
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

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
