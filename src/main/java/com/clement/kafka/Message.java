package com.clement.kafka;

import java.time.LocalDateTime;

public record Message(String message, LocalDateTime createdAt) {
}
