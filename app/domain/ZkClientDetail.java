package domain;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created by jianwl on 2016/1/22.
 */
public class ZkClientDetail {
    private String hostName;
    private String port;
    private Long send;
    private Long received;
    private String establishTime;
    private String lastResponseTime;
    private Long maxLatency;

    public void setZkClientDetail(ZkClientDetail zkClientDetail,String hostName,String port,Long send,Long received,String establishTime,String lastResponseTime,Long maxLatency){
        zkClientDetail.setHostName(hostName);
        zkClientDetail.setPort(port);
        zkClientDetail.setSend(send);
        zkClientDetail.setReceived(received);
        zkClientDetail.setEstablishTime(establishTime);
        zkClientDetail.setLastResponseTime(lastResponseTime);
        zkClientDetail.setMaxLatency(maxLatency);
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Long getSend() {
        return send;
    }

    public void setSend(Long send) {
        this.send = send;
    }

    public Long getReceived() {
        return received;
    }

    public void setReceived(Long received) {
        this.received = received;
    }

    public String getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(String establishTime) {
        this.establishTime = establishTime;
    }

    public String getLastResponseTime() {
        return lastResponseTime;
    }

    public void setLastResponseTime(String lastResponseTime) {
        this.lastResponseTime = lastResponseTime;
    }

    public Long getMaxLatency() {
        return maxLatency;
    }

    public void setMaxLatency(Long maxLatency) {
        this.maxLatency = maxLatency;
    }
}
