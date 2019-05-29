(function () {
  var carousels = document.getElementsByClassName('Carousel');
  for (var c of carousels) {
    (function() {
      var slides = c.getElementsByClassName('slide');
      var dotContainer = c.getElementsByClassName('dots')[0];
      var dots = c.getElementsByClassName('dot');
      var nextButton = c
          .getElementsByClassName('next')[0]
          .getElementsByClassName('button')[0];
      var prevButton = c
          .getElementsByClassName('prev')[0]
          .getElementsByClassName('button')[0];
      var currentActive = 0;

      function activeSlide(index) {
        slides[currentActive].classList.remove('active');
        slides[index].classList.add('active');
        dots[currentActive].classList.remove('active');
        dots[index].classList.add('active');
        currentActive = index;
      }

      function activeNextSlide() {
        var nextIndex = (currentActive + 1) % slides.length;
        activeSlide(nextIndex);
      }
      function activePrevSlide() {
        var prevIndex = currentActive - 1;
        if (prevIndex < 0) prevIndex = slides.length - 1;
        activeSlide(prevIndex);
      }

      for (var i = 0; i < slides.length; i++) {
        var dot = document.createElement('li');
        dot.classList.add('dot');
        dot.setAttribute('data-target-slide', i);
        dot.addEventListener('click', function () {
          activeSlide(this.getAttribute('data-target-slide'));
        });
        dotContainer.appendChild(dot);
      }

      nextButton.addEventListener('click', activeNextSlide);
      prevButton.addEventListener('click', activePrevSlide);

      activeSlide(0);
      setInterval(activeNextSlide, 5000);
    })();
  }
})();
