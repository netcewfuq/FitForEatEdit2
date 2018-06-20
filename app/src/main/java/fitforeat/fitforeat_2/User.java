package fitforeat.fitforeat_2;

public class User {

    public int id;
    public String fname;
    public int weight;
    public int height;
    public int age;

        public User() {  }
        public User(String fname, int weight, int height, int age) {
        this.fname = fname;
        this.weight = weight;
        this.height = height;
        this.age = age;
        }
        public User(int id, String fname, int weight, int height, int age) {
            this.id = id;
            this.fname = fname;
            this.weight = weight;
            this.height = height;
            this.age = age;
        }
        public User set_id(int _id)
        { this.id = _id;
        return this;
        }

        public User setFname(String fname) {
            this.fname = fname;
            return this;
        }
        public User setWeight(int weight) {
            this.weight = weight;
            return this;
        }

    public User setHeight(int height) {
        this.height = height;
        return this;
      }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

        public int get_id() { return this.id; }
        public String getFname() { return this.fname; }
        public int getWeight() { return this.weight; }
        public int getHeight() { return this.height; }
        public int getAge() { return this.age; }


}

