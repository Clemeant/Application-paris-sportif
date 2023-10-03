package bts.sio.paris2024.ui;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UIService {

    @Getter
    @Setter
    public static class Option {
        private Object object;

        private boolean selected;
        public Option(Object object,boolean selected) {
            this.object = object;
            this.selected = selected;
        }
    }
    public List<Option> toOptions(Iterable<?> elements,Object selected) {
        List<Option> options = new ArrayList<>();
        for (Object o : elements) {
            options.add(new Option(o,o.equals(selected)));
        }
        return options;
    }
}
