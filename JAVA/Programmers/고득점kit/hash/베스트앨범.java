package programmers.hash;

import java.util.*;


public class 베스트앨범 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] { "classic", "pop", "classic", "classic", "pop" },
				new int[] { 500, 600, 150, 800, 2500 })));
	}
	static ArrayList<Integer> bestAlbum;
	static ArrayList<Song> songList;
	static HashMap<String, Integer> genreMap;
	static HashMap<String, Integer> albumMap;
	
	public static int[] solution(String[] genres, int[] plays) {
		songList = new ArrayList<>();
		genreMap = new HashMap<>();
		albumMap = new HashMap<>();
		bestAlbum = new ArrayList<>();
		
		for(int i= 0; i < genres.length; i++) {
			int id = i;
			int play = plays[i];
			String genre = genres[i];
			//songList <Song>
			songList.add(new Song(id, play, genre));
			
			//genreMap: <genre, Total-Play>
			genreMap.put(genre, genreMap.getOrDefault(genre, 0) + play);
		}
		
		Collections.sort(songList, new Comparator<Song>() {
			@Override
			public int compare(Song o1, Song o2) {
				if(o1.genre.equals(o2.genre)) {
					return o2.compareTo(o1);
				}else {
					return Integer.compare(genreMap.get(o2.genre), genreMap.get(o1.genre));
				}
			}
		});
		
		
		for(Song s: songList) {
			albumMap.put(s.genre, albumMap.getOrDefault(s.genre, 0) + 1);
			if(albumMap.get(s.genre)>2) {
				continue;
			}
			bestAlbum.add(s.id);
		}
		
		int answer[] = new int[bestAlbum.size()];
		for(int i = 0; i < answer.length; i++) {
			answer[i] = bestAlbum.get(i);
		}
		
		return answer;
	}
}

class Song implements Comparable <Song>{
	int id, play;
	String genre;
	
	Song(int id, int play, String genre){
		this.id = id;
		this.play = play;
		this.genre = genre;
	}

	public int compareTo(Song o) {
		return Integer.compare(this.play, o.play);
	}
}