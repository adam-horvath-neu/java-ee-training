package hu.neuron.service.vo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.sound.midi.MidiDevice.Info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class UserResult {

	@SerializedName("results")
	@Expose
	private List<UserVo> results = new ArrayList<UserVo>();
	@SerializedName("info")
	@Expose
	private Info info;

	public List<UserVo> getResults() {
		return results;
	}

	public void setResults(List<UserVo> results) {
		this.results = results;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

}