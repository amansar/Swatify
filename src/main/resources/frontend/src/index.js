var MainComponent = React.createClass({
  render: function() {
    return rce('div', [
      rce(app.components.Header, {}),
      rce('p', 'Welcome to Swatify!')
    ]);
  }
});

ReactDOM.render(
  rce(MainComponent),
  document.getElementById('react-target')
);
