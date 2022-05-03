class Main {
    public static void main(String[] args) {
        Corpus corpus = new Corpus("documents/");
        System.out.println(corpus);

        int numCluster = 3;
        int maxIteration = 6;
        ClusteringAlgorithm clustering = new ClusteringAlgorithm(numCluster, corpus, maxIteration);
        for(int i = 0; i < numCluster; i++) {
            System.out.println("cluster " + i + ": " + clustering.getCluster(i));
        }
    }
}

