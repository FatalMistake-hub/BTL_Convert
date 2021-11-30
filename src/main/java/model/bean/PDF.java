package model.bean;

public class PDF {
	private String FileName;
    private String FilePath;
    private String TargetPath;
    private Integer Result;
	private Integer ID;
    private String User;
    public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getFilePath() {
		return FilePath;
	}
	public void setFilePath(String filePath) {
		FilePath = filePath;
	}
	public String getTargetPath() {
		return TargetPath;
	}
	public void setTargetPath(String targetPath) {
		TargetPath = targetPath;
	}
	public String getResultString() {
        switch (getResult()) {
            case -1:
                return "Error";
            case 0:
                return "Pending";
            case 1:
                return "Converting";
            case 2:
                return "Success";
            default:
                return "Unknown";
        }
    }
	public Integer getResult() {
		return Result;
	}
	public void setResult(Integer result) {
		Result = result;
	}
	
}
