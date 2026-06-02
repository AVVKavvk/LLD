import Signleton.Database;
void main() {
 Database db = Database.getInstance();

 db.query("SELECT * FROM users");

}