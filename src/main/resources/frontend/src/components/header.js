app.components.Header = React.createClass({
  render: function() {
    return rce('h1', {
      id: 'header'
    }, 'Swatify');
  }
});

app.components.Header.propTypes = {
  name: React.PropTypes.string.isRequired
}
