
package hu.schonherz.blog.service.api.user.vo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class UserResult {

@SerializedName("results")
@Expose
private List<User> results = new ArrayList<User>();
@SerializedName("info")
@Expose
private Info info;

public List<User> getResults() {
return results;
}

public void setResults(List<User> results) {
this.results = results;
}

public Info getInfo() {
return info;
}

public void setInfo(Info info) {
this.info = info;
}

}