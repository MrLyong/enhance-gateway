package org.iblog.enhance.gateway.db.filter;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @author lance
 */
public class OpenApiFilter {
    public final List<String> uris;
    public final List<String> methods;
    public final List<String> codes;
    public final List<String> types;
    public final long start;
    public final long end;
    public final int from;
    public final int to;

    private OpenApiFilter() {
        this(new Builder());
    }

    private OpenApiFilter(Builder builder) {
        this.uris = builder.uris;
        this.methods = builder.methods;
        this.codes = builder.codes;
        this.types = builder.types;
        this.start = builder.start;
        this.end = builder.end;
        this.from = builder.from;
        this.to = builder.to;
    }

    public static class Builder {
        private List<String> uris;
        private List<String> methods;
        private List<String> codes;
        private List<String> types;
        private long start = Long.MIN_VALUE;
        private long end = Long.MAX_VALUE;
        private int from = 0;
        private int to = Integer.MAX_VALUE;

        public OpenApiFilter build() {
            return new OpenApiFilter(this);
        }

        public Builder setUris(List<String> uris) {
            if (CollectionUtils.isEmpty(uris)) {
                this.uris = null;
            } else {
                this.uris = uris;
            }
            return this;
        }

        public Builder setMethods(List<String> methods) {
            if (CollectionUtils.isEmpty(methods)) {
                this.methods = null;
            } else {
                this.methods = methods.stream()
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
            }
            return this;
        }

        public Builder setCodes(List<String> codes) {
            if (CollectionUtils.isEmpty(codes)) {
                this.codes = null;
            } else {
                this.codes = codes;
            }
            return this;
        }

        public Builder setTypes(List<String> types) {
            if (CollectionUtils.isEmpty(types)) {
                this.types = null;
            } else {
                this.types = types;
            }
            return this;
        }

        public Builder setStart(long start) {
            this.start = start;
            return this;
        }

        public Builder setEnd(long end) {
            this.end = end;
            return this;
        }

        public Builder setFrom(int from) {
            this.from = from;
            return this;
        }

        public Builder setTo(int to) {
            this.to = to;
            return this;
        }
    }
}
