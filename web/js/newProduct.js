/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
document.getElementById("notifyButton").addEventListener("click", function () {
    const notificationBox = document.getElementById("notificationBox");
    // Toggle hiển thị ô thông báo
    notificationBox.style.display = notificationBox.style.display === "none" ? "block" : "none";

    if (notificationBox.style.display === "block") {
        fetchNewEvents(); // Lấy dữ liệu nếu hộp được mở
    }
});
document.addEventListener("click", function (event) {
    const notificationBox = document.getElementById("notificationBox");
    const notifyButton = document.getElementById("notifyButton");
    if (!notificationBox.contains(event.target) && !notifyButton.contains(event.target)) {
        notificationBox.style.display = "none";
    }
});

function fetchNewEvents() {
    fetch('checkNewEvent')
            .then(response => response.json())
            .then(events => {
                const notificationBox = document.getElementById("notificationBox");
                notificationBox.innerHTML = "";

                if (events.length > 0) {
                    updateNotificationIndicator(true);
                    events.forEach(event => {
                        const eventElement = document.createElement("div");
                        eventElement.classList.add("notification-item");
                        const linkElement = document.createElement("a");
                        linkElement.href = "eventDetail?eventId=" + event.eventId;
                        const titleElement = document.createElement("strong");
                        titleElement.textContent = event.eventName;
                        const descriptionElement = document.createElement("p");
                        descriptionElement.textContent = event.eventLocation + "," + event.eventCity;
                        const dateElement = document.createElement("small");
                        dateElement.textContent = event.startDate;
                        eventElement.appendChild(titleElement);
                        eventElement.appendChild(descriptionElement);
                        eventElement.appendChild(dateElement);
                        linkElement.appendChild(eventElement);
                        notificationBox.appendChild(linkElement);
                    });
                } else {
                    updateNotificationIndicator(false);
                    const noEventMessage = document.createElement("div");
                    noEventMessage.classList.add("no-event-message");
                    noEventMessage.textContent = "Không có sự kiện mới.";
                    notificationBox.appendChild(noEventMessage);
                }


            })
            .catch(error => console.error("Error fetching events:", error));
}

function updateNotificationIndicator(hasNewProducts) {
    const indicator = document.getElementById("newProductIndicator");
    if (hasNewProducts) {
        indicator.style.display = "block";
    } else {
        indicator.style.display = "none";
    }
}
// Gọi hàm fetchNewEvents mỗi 5 giây (5000 milliseconds)
setInterval(fetchNewEvents, 1000);