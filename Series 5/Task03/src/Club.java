import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Club.
 */
public class Club {
    private String name;
    private final Channel CNFollowers = new Channel();
    private final Channel PNFollowers = new Channel();
    private final Channel MNFollowers = new Channel();
    private final ArrayList<Player> players = new ArrayList<>();
    private final ArrayList<Match> matches = new ArrayList<>();

    /**
     * Instantiates a new Club.
     *
     * @param name the name
     */
    public Club(String name) {
        this.name = name;
    }

    /**
     * Subscribe.
     *
     * @param follower the follower
     * @param type     the type
     */
    public void subscribe(Follower follower, String type) {
        if (type.equalsIgnoreCase("Club News")) {
            CNFollowers.addFollower(follower);
        } else if (type.equalsIgnoreCase("Player News"))
            PNFollowers.addFollower(follower);
        else if (type.equalsIgnoreCase("Match News"))
            MNFollowers.addFollower(follower);
    }

    /**
     * Unsubscribe.
     *
     * @param follower the follower
     * @param type     the type
     */
    public void unsubscribe(Follower follower, String type) {
        if (type.equalsIgnoreCase("Club News")) {
            CNFollowers.removeFollower(follower);
        } else if (type.equalsIgnoreCase("Player News"))
            PNFollowers.removeFollower(follower);
        else if (type.equalsIgnoreCase("Match News"))
            MNFollowers.removeFollower(follower);
    }

    /**
     * Add player.
     *
     * @param player the player
     */
    public void addPlayer(Player player) {
        players.add(player);
        Announcement announcement = new Announcement("The player, " + player.getName() + "has joined " + name,
                "Finally the " + player.getAge() + " years old player, " + player.getName() + " with ID: " + player.getID()
                        + " has joined the club");
        PNFollowers.notifyFollowers("Player News", announcement);
    }

    /**
     * Add match.
     *
     * @param match the match
     */
    public void addMatch(Match match) {
        matches.add(match);
        Announcement announcement = new Announcement(name + " has a new game now!",
                name + " goes against " + match.getOpponentName() + " at the date:" + match.getDate());
        MNFollowers.notifyFollowers("Match News", announcement);
    }

    /**
     * Publish club news.
     */
    public void publishClubNews() {
        Announcement announcement = new Announcement(name + " has been suspended",  name + " after trying to leave UCL and join the European Super League,\n" +
                "has been disbanded by the order of FIFA");
        CNFollowers.notifyFollowers("Club News", announcement);

    }
}
