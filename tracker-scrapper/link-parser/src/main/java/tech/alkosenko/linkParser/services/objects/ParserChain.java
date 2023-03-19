package tech.alkosenko.linkParser.services.objects;
import java.net.URL;

abstract public class ParserChain {
    public ParserChain next = null;

    public void setNext(ParserChain next) {
        this.next = next;
    }

    public ServiceData parse(URL url) {
        ServiceData result = getServiceData(url);
        return result != null ? result : next != null ? next.parse(url) : null;
    }

    protected abstract ServiceData getServiceData(URL url);
}
