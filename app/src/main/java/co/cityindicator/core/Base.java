package co.cityindicator.core;

/**
 * Contain basic properties, which every child inherit.
 * Created by Kunal Bhavsar on 27/1/16.
 */
public class Base {
    /**
     * Data loading stage constants
     *  <i>stage1</i> local data of object loaded, not relational data.
     *  <i>stage2</i> local data of object along with 1 depth of relational data loaded.
     *  <i>stage3</i> whole data of object loaded.
     */
    public static final int DATA_LOADING_STAGE1 = 1;
    public static final int DATA_LOADING_STAGE2 = 2;
    public static final int DATA_LOADING_STAGE3 = 3;

    /**
     * Local database id of the object.
     */
    protected long id;
    /**
     * Remote server database id of the object.
     */
    protected long resourceId;
    /**
     * Current version of the object.
     */
    protected int version;

    /**
     * Defines data loading stage of object
     *  <i>stage1</i> local data of object loaded, not relational data.
     *  <i>stage2</i> local data of object along with 1 depth of relational data loaded.
     *  <i>stage3</i> whole data of object loaded.
     */
    protected int getDataLoadingStage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getResourceId() {
        return resourceId;
    }

    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getGetDataLoadingStage() {
        return getDataLoadingStage;
    }

    public void setGetDataLoadingStage(int getDataLoadingStage) {
        this.getDataLoadingStage = getDataLoadingStage;
    }
}
