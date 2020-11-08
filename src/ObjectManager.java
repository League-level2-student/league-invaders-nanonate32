import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
RocketShip rocket;
ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
ArrayList<Alien> aliens = new ArrayList<Alien>();
Random random = new Random();

ObjectManager(RocketShip rocket){
this.rocket = rocket;
}
void addProjectile(Projectile projectile) {
	projectiles.add(projectile);
}
void addAlien(Alien alien) {
	aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));	
}
void update() {
	
}

}
