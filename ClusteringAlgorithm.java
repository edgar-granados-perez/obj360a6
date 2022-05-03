import java.util.LinkedList;

class ClusteringAlgorithm {
  private LinkedList<Integer>[] cluster;
  private int[] centroidList;

  public ClusteringAlgorithm(int numCluster, Corpus corpus, int maxIteration){
     centroidList = new int[numCluster];
     cluster = new LinkedList[numCluster];

    for(int i = 0; i < numCluster; i++){
      centroidList[i] = i;
      cluster[i] = new LinkedList<Integer>();
    }

    while(maxIteration != 0){
      for(int i = 0; i < numCluster; i++){
        cluster[i].clear();
      }

      for(int x = 0; x < corpus.size(); x++){
        double highSim = -1.0;
        int closeSim = -1;

        for(int s = 0; s < numCluster; s++){
          if(corpus.similarity(centroidList[s], x) > highSim){
            highSim = corpus.similarity(centroidList[s], x);
            closeSim = s;
          }
        }

        cluster[closeSim].add(x);
      }

      for(int iter = 0; iter < numCluster; iter++){
        double mCentroid = 0;
        int index = -1;

        for(int x = 0; x < cluster[iter].size(); x++){
          double total = 0;

          for(int y = 0; y < cluster[iter].size(); y++){
            total = total + corpus.similarity(cluster[iter].get(x), cluster[iter].get(y));
            if(total > mCentroid){
              index = cluster[iter].get(x);
              mCentroid = total;
            }
          }
        }
        centroidList[iter] = index;
      }
      maxIteration--;
    }
  }

  public LinkedList<Integer> getCluster(int i){
    return cluster[i];
  }
}
