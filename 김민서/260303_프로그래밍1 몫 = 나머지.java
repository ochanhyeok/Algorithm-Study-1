class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;

        for(int i = 1; i < n; i++) {
            cnt += i * n + i;
        }

        System.out.println(cnt);
    }
}