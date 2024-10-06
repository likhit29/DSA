// Assignment - 3
// Likhit Chaudhary
// 123B1B100

/*
Functions Implemented - 
1. Adding at Start
2. Adding at Last
3. Removing from Start
4. Removing from Last
5. Adding at a given index
6. Reverse Linked list
7. Finding element by song id (iterative search)
8. Recursive search
9. Size of linked list(Total no of songs)
10. Printing of linked list
*/

public class Likhit_100_3 {
    public static class Song {

        int song_id;
        String title;
        String artist;
        double duration;
        Song next;

        public Song(int song_id, String title, String artist, double duration) {
            this.song_id = song_id;
            this.title = title;
            this.artist = artist;
            this.duration = duration;
            this.next = null;
        }
    }

    public static Song head;
    public static Song tail;
    public int size = 0;

    public void addFirst(int song_id, String title, String artist, double duration) {
        Song newSong = new Song(song_id, title, artist, duration);
        size++;
        if (head == null) {
            head = tail = newSong;
            return;
        }
        newSong.next = head;
        head = newSong;
    }

    public void addLast(int song_id, String title, String artist, double duration) {
        Song newSong = new Song(song_id, title, artist, duration);
        size++;
        if (head == null) {
            head = tail = newSong;
            return;
        }
        tail.next = newSong;
        tail = newSong;

    }

    public void addMiddle(int idx, int song_id, String title, String artist, double duration) {
        if (idx == 0) {
            addFirst(song_id, title, artist, duration);
            return;
        }
        Song newSong = new Song(song_id, title, artist, duration);
        size++;
        Song temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newSong.next = temp.next;
        temp.next = newSong;

    }

    public void removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
        } else if (size == 1) {
            head = tail = null;
            size = 0;
        }
        head = head.next;
        size--;
    }

    public void removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
        } else if (size == 1) {
            head = tail = null;
            size = 0;
        }
        Song temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }

    public void iterative_search(int key) {
        Song temp = head;
        int i = 0;
        while (temp != null) {
            if (key == temp.song_id) {
                System.out.println("Song found at index " + i);
                return;
            }
            temp = temp.next;
            i++;
        }
        System.out.println("Song not found");
    }

    public void reverse() {
        Song prev = null;
        Song curr = tail = head;
        Song next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Recursive search
    public int helper(Song head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.song_id == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }
    public int recursive_search(int key) {
        return helper(head, key);
    }

    public void print() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Song temp = head;
        while (temp != null) {
            System.out.print(temp.song_id + " - " + temp.title + " - " + temp.artist + " - " + temp.duration + "    ->    ");
            temp = temp.next;
        }
        System.out.println("null  ");
    }

    public static void main(String[] args) {
        Likhit_100_3 ll = new Likhit_100_3();
        ll.addFirst(1, "Song 1", "Artist 1", 5);
        ll.addFirst(2, "Song 2", "Artist 2", 6);
        ll.addLast(3, "Song 3", "Artist 3", 4);
        ll.addLast(4, "Song 4", "Artist 4", 5.56);
        ll.print();
        System.out.println("\nTotal no of Songs in Playlist - " + ll.size);
        System.out.println("\nRemoving first song");
        ll.removeFirst();
        ll.print();
        System.out.println("\nRemoving last song");
        ll.removeLast();
        ll.print();
        System.out.println("\nAdding song at index 1");
        ll.addMiddle(1, 6, "Song 6", "Artist 6", 8);
        ll.print();
        System.out.print("\nFinding song by song id '2' - ");
        ll.iterative_search(2);
        System.out.print("\nFinding song by song id '6' - ");
        System.out.println("Song found at index " + ll.recursive_search(6));
        System.out.println("\nReversing the Playlist - ");
        ll.reverse();
        ll.print();

    }
}