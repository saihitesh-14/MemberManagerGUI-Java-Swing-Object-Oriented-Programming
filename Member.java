public class Member {
    private String name;
    private String email;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Copy constructor
    public Member(Member other) {
        this.name = other.name;
        this.email = other.email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Member)) return false;
        Member other = (Member) obj;
        return name.equals(other.name) && email.equals(other.email);
    }
    
//    @Override
//    public boolean equals(Object obj) {
//    	if(obj instanceof Member) {
//    		Member other = (Member)obj;
//    		return this.name==other.name && this.email == other.email;    		
//    	}else {
//    		return false;
//    	}
//    }

    @Override
    public String toString() {
        return name + " (" + email + ")";
    }
}
