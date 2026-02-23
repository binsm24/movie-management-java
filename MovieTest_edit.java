import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Movie{
    // 변수 선언
    private String title;
    private String director;
    private String genre;
    private String year;

    // 생성자 메소드
    public Movie(String title, String director, String genre, String year){
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.year = year;
    }

    // get, set 메소드
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    // toString 메소드
    public String toString(){
        return this.title + " | " + this.director + " | " + this.genre + " | " + this.year;
    }

}

public class MovieTest {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();

        while (true) {
            System.out.println("========== 영화 정보 관리 ==========");
            System.out.println("1.입력/2.출력/3.검색/4.수정/5.삭제/6.종료");
            Scanner sc = new Scanner(System.in);
            System.out.print("메뉴 선택: ");
            int menu = sc.nextInt();
            sc.nextLine();

            // 영화 정보 입력
            if (menu == 1){
                System.out.print("제목: ");
                String title = sc.nextLine();
                System.out.print("감독: ");
                String director = sc.nextLine();
                System.out.print("장르: ");
                String genre = sc.nextLine();
                System.out.print("년도: ");
                String year = sc.nextLine();
                movies.add(new Movie(title, director, genre, year));
                System.out.println("등록되었습니다.");
            }

            // 영화 정보 출력
            if (menu == 2){
                System.out.println("[제목 | 감독 | 장르 | 년도]");
                for (Movie mov : movies) {
                    System.out.println(mov);
                }
            }

            // 영화 정보 검색
            if (menu == 3){
                System.out.print("검색할 영화 제목: ");
                String title = sc.nextLine();
                for (Movie mov : movies){
                    if (mov.getTitle().equals(title)){
                        System.out.println(mov);
                    }
                }
            }

            // 영화 정보 수정
            if (menu == 4) {
                System.out.print("수정할 영화 제목: ");
                String title = sc.nextLine();
                for (Movie mov : movies) {
                    if (mov.getTitle().equals(title)) {
                        System.out.println("빈칸(Enter) 입력 시 기존 값 유지");
                        System.out.print("새 제목(" + mov.getTitle() + "): ");
                        String new_title = sc.nextLine();
                        if (!new_title.isEmpty()){ // 빈칸이 아닐 때 값 변경
                            mov.setTitle(new_title);
                        }
                        System.out.print("새 감독(" + mov.getDirector() + "): ");
                        String new_dir = sc.nextLine();
                        if (!new_dir.isEmpty()){
                            mov.setDirector(new_dir);
                        }
                        System.out.print("새 장르(" + mov.getGenre() + "): ");
                        String new_gen = sc.nextLine();
                        if (!new_gen.isEmpty()){
                            mov.setGenre(new_gen);
                        }
                        System.out.print("새 년도(" + mov.getYear() + "): ");
                        String new_year = sc.nextLine();
                        if (!new_year.isEmpty()){
                            mov.setYear(new_year);
                        }
                        System.out.println("수정 완료: " + mov);
                    }
                }
            }

            // 영화 정보 삭제
            if (menu == 5) {
                System.out.print("삭제할 영화 제목: ");
                String title = sc.nextLine();
                for (int i = 0; i < movies.size(); i++) {
                    if (movies.get(i).getTitle().equals(title)) {
                        movies.remove(i); 
                        System.out.println("삭제 완료: " + title);
                        break;
                    }
                }
            }

            // 프로그램 종료
            if (menu == 6) {
                System.out.print("프로그램을 종료합니다.");
                System.out.println();
                break;
            }
            System.out.println();
        }
    }
}
