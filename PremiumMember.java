package Library;

public class PremiumMember extends Member {
    public PremiumMember(String memberId, String name) {
        super(memberId, name);
    }

    @Override
    public int getBorrowLimit() {
        return 5; // Premium can borrow more
    }
}
