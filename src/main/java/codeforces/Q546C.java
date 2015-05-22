package codeforces;

import java.util.*;

public class Q546C {
    static public void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Deque<Integer> initHand1 = new LinkedList<>();
        Deque<Integer> initHand2 = new LinkedList<>();
        int initHandNo1 = in.nextInt();
        for (int i = 0; i < initHandNo1; i++) initHand1.offer(in.nextInt());
        int initHandNo2 = in.nextInt();
        for (int i = 0; i < initHandNo2; i++) initHand2.offer(in.nextInt());
        Queue<Integer> playHand1 = new LinkedList<>(initHand1);
        Queue<Integer> playHand2 = new LinkedList<>(initHand2);

        int gameNo = 0;
        HashSet<LinkedList<Integer>> seen = new HashSet<>();
        while (!playHand1.isEmpty() && !playHand2.isEmpty()) {
            int card1 = playHand1.poll();
            int card2 = playHand2.poll();

            if (card1 > card2) {
                playHand1.offer(card2);
                playHand1.offer(card1);
            } else {
                playHand2.offer(card1);
                playHand2.offer(card2);
            }
            gameNo++;

            LinkedList<Integer> list = new LinkedList<>(playHand1);
            list.add(0);
            list.addAll(playHand2);
            if (seen.contains(list)) {
                System.out.println(-1);
                return;
            } else {
                seen.add(list);
            }

        }
        if (playHand1.isEmpty()) {
            System.out.println(gameNo + " " + 2);
        } else {
            System.out.println(gameNo + " " + 1);
        }
    }
}
