package com.hszg.demo.data.api;

import org.springframework.http.HttpStatus;

import java.util.Optional;

public class ManagerResult {
        private final HttpStatus status;
        private final Object payload;
        private final String message;

        public ManagerResult(HttpStatus status, Object payload, String message) {
            this.status = status;
            this.payload = payload;
            this.message = message;
        }

        public ManagerResult(HttpStatus status, String message) {
            this.status = status;
            this.payload = null;
            this.message = message;
        }

        public HttpStatus getStatus() {
            return status;
        }

        public Optional<Object> getPayload() {
            return Optional.ofNullable(payload);
        }
        public String getMessage() {
            return message;
        }

}
